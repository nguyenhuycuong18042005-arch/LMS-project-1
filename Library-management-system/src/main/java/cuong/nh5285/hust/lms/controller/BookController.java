package cuong.nh5285.hust.lms.controller;

import cuong.nh5285.hust.lms.model.Book;
import cuong.nh5285.hust.lms.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public String listBook(Model model){
        System.out.println("GET /books called");
        model.addAttribute("books", bookRepository.findAll());
        return "book-list";
    }

    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book){
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("book", bookRepository.findById(id).orElseThrow());
        return "book-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
