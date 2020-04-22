package com.elasticsearch.restclient.controller;


import com.elasticsearch.restclient.entity.Book;
import com.elasticsearch.restclient.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.avg.Avg;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.elasticsearch.search.aggregations.metrics.tophits.ParsedTopHits;
import org.elasticsearch.search.profile.ProfileShardResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/***
 * 演示 controller 接收各种请求及参数
 *
 * @author chailonglong
 * @date 2019/10/14 10:42
 **/
@RestController
@Api(value = "Service Controller|业务Controller")
@Slf4j
public class ServiceController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    @ApiOperation(value = "添加元素", notes = "添加元素")
    public IndexResponse addTarget(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("/getBook")
    @ApiOperation(value = "获取book", notes = "获取book,全词匹配，不分词")
    public SearchHits getBook(@RequestParam("书名") String name) {
        return bookService.getBook(name);
    }

    @DeleteMapping("/deleteBook")
    @ApiOperation(value = "删除book", notes = "删除book")
    public DeleteResponse deleteBook(@RequestParam("书名") String name) {
        return bookService.deleteBook(name);

    }

    @PostMapping("/updateBook")
    @ApiOperation(value = "更新book", notes = "更新book")
    public UpdateResponse updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);

    }


    @PostMapping("/aveAggreate")
    @ApiOperation(value = "Matrix聚合索引", notes = "Matrix聚合索引")
    public Max aveAggreate(@RequestParam("聚合索引关键字") String key) {
        return bookService.averageAggregate(key);
    }

    @PostMapping("/topAggreate")
    @ApiOperation(value = "top聚合索引", notes = "top聚合索引")
    public ParsedTopHits topAggreate(@RequestParam("聚合索引关键字") String key) {
        return bookService.topAggregate(key);
    }






}
