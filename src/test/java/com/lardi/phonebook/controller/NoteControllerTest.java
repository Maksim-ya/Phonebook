package com.lardi.phonebook.controller;

import com.lardi.phonebook.repository.NoteRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Created by User on 27/10/2017.
 */
public class NoteControllerTest {

//    @Mock
//    StoreManagementService storeService;

    @Mock
    NoteRepository noteRepository;

    @InjectMocks
    NoteController noteController;

    @Before
    public void setUp(NoteController noteController) {
        MockitoAnnotations.initMocks(this);
        setUp(this.noteController);
    }



    @Test
    public void listOfNotes() throws Exception {

    }

    @Test
    public void addNote() throws Exception {

    }

    @Test
    public void removeNote() throws Exception {

    }

    @Test
    public void editNote() throws Exception {

    }

    @Test
    public void noteData() throws Exception {

    }

}