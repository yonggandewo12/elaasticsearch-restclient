package com.elasticsearch.restclient.service;

import com.elasticsearch.restclient.entity.Book;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.elasticsearch.search.aggregations.metrics.tophits.ParsedTopHits;

/**
 * @Description
 * @ClassName BookService
 * @Author xuliang
 * @date 2020.04.17 17:30
 */
public interface ElasticService {

    IndexResponse addBook(Book book);

    DeleteResponse deleteBook(String name);

    SearchHits getBook(String name);

    UpdateResponse updateBook(Book book);

    Max averageAggregate(String key);

    ParsedTopHits topAggregate(String key);

    ParsedLongTerms termsAggregate(String key);

    ParsedLongTerms logTermsMultiAggregate(String key);

    ParsedStringTerms filterAggregate(String include, String exclude, String field);




}
