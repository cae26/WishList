
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.Item
import com.example.wishlist.R

class WishListAdapter (private val items: List<Item>) : RecyclerView.Adapter<WishListAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTextView: TextView
        val urlTextView: TextView
        val priceTextView: TextView

        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            itemTextView = itemView.findViewById(R.id.itemText)
            urlTextView = itemView.findViewById(R.id.urlText)
            priceTextView = itemView.findViewById(R.id.priceText)
            //itemView.setOnClickListener(this)
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }


    override fun getItemCount(): Int {
       // TODO("Not yet implemented")
        return items.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items.get(position)
        // Set item views based on views and data model
        holder.itemTextView.text = item.itemName
        holder.urlTextView.text = item.webLink
        holder.priceTextView.text = item.price
    }






}