package roommvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import roommvvm.Database.NotesDatabase
import roommvvm.Repository.NotesRepository
import roommvvm.model.Notes

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val repository: NotesRepository

    init {
        val dao= NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository= NotesRepository(dao)
    }
    fun addNotes(notes: Notes){
        repository.insertNotes(notes)
    }
    fun getNOtes():LiveData<List<Notes>> = repository.getAllNotes()

    fun deleteNotes(id: Int){
        repository.deleteNotes(id)
    }
    fun updateNotes(notes: Notes){
        repository.updateNotes(notes)
    }

}