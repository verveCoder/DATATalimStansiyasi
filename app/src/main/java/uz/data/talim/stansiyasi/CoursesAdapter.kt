package uz.data.talim.stansiyasi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.reflect.KFunction1

class CoursesHolder(view: View): ViewHolder(view)

class CoursesAdapter(private val CoursesList: List<Course>, val navigate: KFunction1<Int, Unit>): Adapter<CoursesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.courses, parent, false)

        return CoursesHolder(view)
    }

    override fun onBindViewHolder(holder: CoursesHolder, position: Int) {
        val course: Course = CoursesList[position]
        val courseName: TextView = holder.itemView.findViewById(R.id.name)
        val courseDuration: TextView = holder.itemView.findViewById(R.id.duration)
        val coursePrice: TextView = holder.itemView.findViewById(R.id.price)

        courseName.text = course.name
        courseDuration.text = course.duration
        coursePrice.text = course.price

        holder.itemView.setOnClickListener {
            navigate(R.id.from_catalog_to_details)
        }
    }

    override fun getItemCount(): Int {
        return CoursesList.size
    }
}