package com.example.diaryapp.ui.adapter

import android.content.Context
import android.graphics.Color
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.diaryapp.databinding.ItemDiaryBinding
import com.example.diaryapp.ui.fragments.HomeFragmentDirections
import roommvvm.model.Notes

class NotesAdapter(val requireContext: Context,var notesList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.notesViewHolder>(){

    fun filtering(newFilteredList: ArrayList<Notes>) {
        notesList= newFilteredList
        notifyDataSetChanged()
    }
    class notesViewHolder(val binding: ItemDiaryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(ItemDiaryBinding.inflate(
            LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data =notesList[position]
        val span= Html.fromHtml(data.title,0)
        holder.binding.date.text=data.date
        holder.binding.titleNotes.text=span

        when(data.flag){
            "1" ->holder.binding.savednotesView.setCardBackgroundColor(Color.parseColor("#FFBB86FC"))
            "2" ->holder.binding.savednotesView.setCardBackgroundColor(Color.parseColor("#ffffff"))
            "3" ->holder.binding.savednotesView.setCardBackgroundColor(Color.parseColor("#F475A7"))
            "4" ->holder.binding.savednotesView.setCardBackgroundColor(Color.parseColor("#66FF99"))
            "5" ->holder.binding.savednotesView.setCardBackgroundColor(Color.parseColor("#F1E76D"))
        }

        holder.binding.root.setOnClickListener {
            val action= HomeFragmentDirections.actionHomefragmentToEditfragment2(data)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount()= notesList.size
}