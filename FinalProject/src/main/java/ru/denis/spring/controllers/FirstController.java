package ru.denis.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.denis.spring.dao.NoteDAO;
import ru.denis.spring.model.Note;

@Controller
public class FirstController {
    private final NoteDAO noteDAO;

    public FirstController(NoteDAO personDAO) {
        this.noteDAO = personDAO;
    }
    @GetMapping("/")
    public String home(){

        return "home";
    }
    @GetMapping("/allNotes")
    public String noteList(Model model){
        model.addAttribute("allNote", noteDAO.read());
        return "note/allNote";
    }
    @GetMapping("/{id}")
    public String get(@PathVariable("id") int id,Model model){
        model.addAttribute("id", noteDAO.getNote(id));
        return "note/getNoteById";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("noteId", noteDAO.getNote(id));
        return "note/noteEdit";
    }
    @DeleteMapping("/delete/{id}")
    public String delete( @PathVariable("id") int id) {
        noteDAO.delete(id);
        return "redirect:/allNotes";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("noteId") Note note, @PathVariable("id") int id) {
        noteDAO.update(id, note);
        return "redirect:/allNotes";
    }


    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("newNote",new Note());
        return "note/newNote";
    }
    @PostMapping("/allNotes")
    public String create(@ModelAttribute("newNote") Note note){
        noteDAO.save(note);
        return"redirect:/allNotes";
    }
}
