package ru.fisenko.urlRestApp.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fisenko.urlRestApp.integration.RestClient;
import ru.fisenko.urlRestApp.models.Url;
import ru.fisenko.urlRestApp.repositories.UrlRepository;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class UrlService {
    @Value("${url.generator.count}")
    private int urlCount;
    private long currentUrls;

    private final UrlRepository urlRepository;
    private final RestClient restClient;

    @Autowired
    public UrlService(UrlRepository urlRepository, RestClient restClient) {
        this.urlRepository = urlRepository;
        this.restClient = restClient;
    }

    @Transactional
    public String getUrl() {
        checkNext();
        String url = urlRepository.findFirstByUrlIsNotNull().getUrl();
        urlRepository.deleteById(url);
        currentUrls--;
        return url;
    }

    private void checkNext() {
        if (currentUrls > 0) {
            return;
        }
        long urlCountInRepo = urlRepository.count();
        if (urlCountInRepo > 0) {
            currentUrls = urlCountInRepo;
        }
        else {
            generateUrls(urlCount);
            currentUrls = urlRepository.count();
        }
    }

    @Transactional
    public void generateUrls(int urlCount) {
        Random random = new Random();
        long salt = random.nextLong();
        long time = Calendar.getInstance().getTimeInMillis();
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < urlCount; i++)
            urls.add(DigestUtils.md5Hex(salt + i + time + ""));
        urls.removeAll(Arrays.asList(restClient.sendPostRequest(urls)));
        urlRepository.saveAll(urls.stream().map(Url::new).toList());
        currentUrls = urlRepository.count();
    }
}
