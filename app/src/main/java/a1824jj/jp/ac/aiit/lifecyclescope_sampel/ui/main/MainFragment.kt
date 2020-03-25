package a1824jj.jp.ac.aiit.lifecyclescope_sampel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import a1824jj.jp.ac.aiit.lifecyclescope_sampel.R
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        lifecycleScope.launch(Dispatchers.IO) {
            Log.i("MyTag", "onActivityCreated - thread is : ${Thread.currentThread().name}")
        }

        lifecycleScope.launchWhenCreated {
            Log.i("MyTag", "launchWhenCreated - thread is : ${Thread.currentThread().name}")

        }

        lifecycleScope.launchWhenStarted {
            Log.i("MyTag", "launchWhenStarted - thread is : ${Thread.currentThread().name}")

        }

        lifecycleScope.launchWhenResumed {
            Log.i("MyTag", "launchWhenResumed - thread is : ${Thread.currentThread().name}")

        }
    }

}
