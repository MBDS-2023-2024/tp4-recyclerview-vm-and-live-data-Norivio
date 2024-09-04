package org.mbds.unice.github.ui.users

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import org.mbds.unice.github.R
import org.mbds.unice.github.data.model.User
import javax.sql.DataSource

//TODO : Use viewBinding instead of findviewbyid
class ListUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var avatar: ImageView = itemView.findViewById(R.id.item_list_user_avatar)
    private val username: TextView = itemView.findViewById(R.id.item_list_user_username)
    private val deleteButton: ImageButton = itemView.findViewById(R.id.item_list_user_delete_button)

    fun bind(user: User, callback: UserListAdapter.Listener) {
        // TODO : Utiliser une librairie pour charger l'image (glide, coil, )
        username.text = user.login
        Glide.with(itemView.context)
            .load(user.avatarUrl)
            .into(avatar)

        deleteButton.setOnClickListener { callback.onClickDelete(user) }
    }

}