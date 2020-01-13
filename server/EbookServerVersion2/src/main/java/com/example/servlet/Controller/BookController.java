package com.example.servlet.Controller;

import com.example.servlet.entity.Book;
import com.example.servlet.entity.BookCombination;
import com.example.servlet.entity.staBook;
import com.example.servlet.entity.tools.FileNameUtil;
import com.example.servlet.entity.tools.FileUploadUtil;
import com.example.servlet.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/allBook")
    public List<BookCombination> findBook()
    {
        return bookService.findAllBook();
    }

    /**
     *
     * @param book_id
     * @param name
     * @param author
     * @param isbn
     * @param abstrac
     * @param img_src
     * @param price
     * @param amount
     * @param sales
     */
    @GetMapping(value="/UpdateBook")
    public void saveOrUpdateBook(Integer book_id,String name,String author,String  isbn,String abstrac,String img_src,Integer price,Integer amount,Integer sales)
    {
        bookService.updateBook(book_id, name, author, isbn, abstrac, img_src, price, amount, sales);
    }

    /**
     *
     * @param book_id
     * @return
     */
    @GetMapping(value = "/selectBookById")
    public Book selectBookById(Integer book_id)
    {
        return bookService.selectBookById(book_id);
    }

    /**
     *
     * @param name
     * @param author
     * @param isbn
     * @param abstrac
     * @param img_src
     * @param price
     * @param amount
     */
    @GetMapping(value = "/addBook")
    public void addBook(String name,String author,String isbn,String abstrac,String img_src,Integer price,Integer amount){
        bookService.addBook(name, author, isbn, abstrac, img_src, price, amount);
    }

    /**
     *
     * @param book_id
     */
    @GetMapping(value = "/deleteBook")
    public void deleteBook(Integer book_id)
    {
        bookService.deleteBook(book_id);
    }

    /**
     *
     * @param time1
     * @param time2
     * @return
     */
    @GetMapping(value = "/statisticBookData")
    public List<staBook> statisticBookData(String time1,String time2)
    {
        return bookService.statisticBookData(time1,time2);
    }

    /**
     *
     * @param book_id
     * @param user_id
     * @param content
     * @return
     */
    @GetMapping(value = "/uploadComment")
    public String uploadComment(Integer book_id,String user_id,String content)
    {
        return bookService.uploadComment(book_id,user_id,content);
    }

    /**
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request)
    {
        System.out.println("here");
        System.out.println(file.getOriginalFilename());
        String localPath="/run/media/gz/G/c2020spring/SE343/project/database/image";
        String fileName=file.getOriginalFilename();
        fileName= FileNameUtil.getFileName(fileName);
        File dest=new File(localPath+fileName);
        if(FileUploadUtil.upload(file, localPath, fileName)){
            // 将上传的文件写入到服务器端文件夹
            // 获取当前项目运气的完整url
            String requestURL = request.getRequestURL().toString();
            // 获取当前项目的请求路径url
            String requestURI = request.getRequestURI();
            // 得到去掉了uri的路径
            String url = requestURL.substring(0, requestURL.length()-requestURI.length() + 1);
            url+="images/"+ fileName;
            System.out.println(url);
            return  url;

        }
        else{
            System.out.println("未进入upload函数");
        }
        // 返回
        return "fault";

    }

}
