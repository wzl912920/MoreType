package com.werb.library

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import com.werb.library.action.MoreAction

/**
 * [MoreViewHolder] Base ViewHolder implement Action fun
 * Created by wanbo on 2017/7/2.
 */
class MoreViewHolder(itemView: View) : ViewHolder(itemView) {

    private var action: MoreAction? = null

    fun getItemView(): View = itemView

    fun setActionListener(action: MoreAction?) {
        this.action = action
    }

    fun addOnClickListener(viewId: Int) {
         itemView.findViewById<View>(viewId).setOnClickListener { action?.moreListener?.onItemClick(it, layoutPosition) }
    }

    fun addOnClickListener(view: View) {
        view.setOnClickListener { action?.moreListener?.onItemClick(it, layoutPosition) }
    }

    fun addOnLongClickListener(viewId: Int) {
        action?.let {
            it.moreListener?.let {
                val _this = it
                itemView.findViewById<View>(viewId).setOnLongClickListener {
                    _this.onItemLongClick(it, layoutPosition)
                }
            }
        }
    }

    fun addOnLongClickListener(view: View) {
        action?.let {
            it.moreListener?.let {
                val _this = it
                view.setOnLongClickListener {
                    _this.onItemLongClick(view, layoutPosition)
                }
            }
        }
    }
}