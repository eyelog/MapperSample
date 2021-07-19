package ru.eyelog.mappersample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.eyelog.mappersample.R
import ru.eyelog.mappersample.datasource.models.to.SampleDO

class RVAdapter : RecyclerView.Adapter<RVAdapter.RVHolder>() {

    private var data: List<SampleDO> = emptyList()

    fun setData(data: List<SampleDO>){
        this.data = data
    }

    inner class RVHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTextName: TextView? = null
        var tvTextNumber: TextView? = null
        var tvTextType: TextView? = null

        init {
            tvTextName = itemView.findViewById(R.id.tvName)
            tvTextNumber = itemView.findViewById(R.id.tvNumber)
            tvTextType = itemView.findViewById(R.id.tvType)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_data, parent, false)
        return RVHolder(itemView)
    }

    override fun onBindViewHolder(holder: RVHolder, position: Int) {
        holder.tvTextName?.text = data[position].name
        holder.tvTextNumber?.text = data[position].number.toString()
        holder.tvTextType?.text = data[position].typeMode.name
    }

    override fun getItemCount() = data.size
}
