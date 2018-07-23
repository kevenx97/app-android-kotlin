package teste.keven.com.food.ui.adapter

import android.content.Context
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_comida.view.*
import teste.keven.com.food.R
import teste.keven.com.food.models.Comida

class ListDeliciousAdapter(
        private val context: Context,
        private val list: List<Comida>?
): RecyclerView.Adapter<ListDeliciousAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_comida, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comida = list?.get(position)
        comida?.let { holder.setData(it) }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun setData(comida: Comida) {
            itemView.item_comida_nome.text = comida.nome
            itemView.item_comida_descricao.text = comida.descricao
        }
    }
}

