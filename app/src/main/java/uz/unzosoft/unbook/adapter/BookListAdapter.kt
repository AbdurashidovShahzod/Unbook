package uz.unzosoft.unbook.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_recycler.view.*
import uz.unzosoft.unbook.R
import uz.unzosoft.unbook.network.VolumeInfo


class BookListAdapter : RecyclerView.Adapter<BookListAdapter.MyViewHolder>() {
     var bookListData = ArrayList<VolumeInfo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookListAdapter.MyViewHolder {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MyViewHolder(inflate)

    }

    override fun onBindViewHolder(holder: BookListAdapter.MyViewHolder, position: Int) {
        holder.bind(bookListData[position])
    }

    override fun getItemCount(): Int = bookListData.size

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle = view.tvTitle
        val tvPublisher = view.tvPublisher
        val tvDescription = view.tvDescription
        val thumbImageView = view.thumbImageView


        fun bind(data: VolumeInfo) {
            tvTitle.text = data.volumeInfo.title
            tvPublisher.text = data.volumeInfo.publisher
            tvDescription.text = data.volumeInfo.description
            val URL = data.volumeInfo.imageLinks.smallThumbnail

            Glide.with(thumbImageView)
                .load(URL)
                .circleCrop()
                .into(thumbImageView)
        }
    }


}