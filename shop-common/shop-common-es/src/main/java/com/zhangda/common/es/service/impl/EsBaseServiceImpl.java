package com.zhangda.common.es.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import com.zhangda.common.constant.exception.ServiceException;
import com.zhangda.common.es.service.EsBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author zhangda
 * @date: 2023/5/6
 **/
@Service
public class EsBaseServiceImpl implements EsBaseService {

    @Resource(name = "elasticsearchClient")
    private ElasticsearchClient esClient;

    public ElasticsearchClient getEsClient() {
        return esClient;
    }


    @Override
    public void noExistsCreateIndex(String index) throws IOException {
        if (!esClient.indices().exists(b -> b.index(index)).value()) {
            esClient.indices().create(c -> c.index(index));
        }
    }

    @Override
    public void batchDelete(String index, List<Integer> idList) {
        try {
            for (Integer id : idList) {
                DeleteRequest.Builder builder = new DeleteRequest.Builder();
                builder.index(index).id(id + "");
                esClient.delete(builder.build());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(index + "：批量删除失败！错误信息：" + e.getMessage());
        }
    }
}
