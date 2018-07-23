package teste.keven.com.food.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_industrializados.*
import teste.keven.com.food.R
import teste.keven.com.food.service.DeliciousService
import teste.keven.com.food.ui.activity.DeliciousActivity
import teste.keven.com.food.ui.adapter.ListDeliciousAdapter

class IndustrializadosFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_industrializados, container, false)
    }

    override fun onResume() {
        super.onResume()

        DeliciousService.buscar {
            industrializados_recycleview.adapter = ListDeliciousAdapter(context!!, it?.comidas?.filter { it.tipo == 'I' })
        }
    }
}