package ru.denis.spring.dao;

import org.springframework.stereotype.Component;
import ru.denis.spring.model.Note;

import java.util.ArrayList;
import java.util.List;
@Component
public class NoteDAO {
    private int id = 0;
   private List<Note> noteList = new ArrayList<>();
    {
        noteList.add(new Note(id++,"Note0" ));
        noteList.add(new Note(id++,"Note1" ));
        noteList.add(new Note(id++,"Note2" ));
        noteList.add(new Note(id++,"Note3" ));
    }
    public void update(int id, Note note){
        noteList.stream().filter(notes -> notes.getId() == id).findAny().get().setText(note.getText());
    }
    public  List<Note> read(){
        return noteList;
    }
    public Note getNote(final int id){
        return noteList.stream().filter(p -> p.getId() == id).findAny().get();
    }

    public void save(Note note){
        note.setId(id++);
        noteList.add(note);
    }
    public void delete(int id){
        noteList.removeIf(note -> note.getId() == id);
        this.id--;
    }
}
