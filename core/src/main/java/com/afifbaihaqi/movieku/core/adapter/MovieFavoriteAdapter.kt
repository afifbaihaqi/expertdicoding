package com.afifbaihaqi.movieku.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afifbaihaqi.movieku.core.databinding.ListItemBinding
import com.afifbaihaqi.movieku.core.domain.model.Movie
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieFavoriteAdapter : RecyclerView.Adapter<MovieFavoriteAdapter.CourseViewHolder>() {
    private var listCourses = ArrayList<Movie>()
    private var onItemClickCallback: OnItemClickCallback? = null


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }

    fun setCourses(courses: List<Movie>?) {
        if (courses == null) return
        this.listCourses.clear()
        this.listCourses.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourses.size

    inner class CourseViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(course: Movie) {
            with(binding) {
                tvItemTitle.text = course.title
                tvDescription.text = course.description
                Glide.with(itemView.context)
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${course.poster}")
                    .apply(RequestOptions().override(50, 75))
                    .into(imgPoster)
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(course) }
            }
        }
    }
}