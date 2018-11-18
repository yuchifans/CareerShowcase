/*
 * MIT License
 *
 * Copyright (c) 2018 Ahmed AlAskalany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.alaskalany.careershowcase.ui.work;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentWorkListBinding;
import com.alaskalany.careershowcase.ui.ScrollToTop;
import com.alaskalany.careershowcase.viewmodel.WorkListViewModel;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class WorkListFragment extends androidx.fragment.app.Fragment
        implements ScrollToTop, SwipeRefreshLayout.OnRefreshListener {
    
    /**
     *
     */
    protected static final String ARG_COLUMN_COUNT = "column-count";
    
    /**
     *
     */
    private final WorkOnClickCallback workOnClickCallback =
            item -> Toast.makeText(getContext(), "Clicked on WorkEntity Item", Toast.LENGTH_SHORT).show();
    
    /**
     *
     */
    protected FragmentWorkListBinding binding;
    
    /**
     *
     */
    protected WorkAdapter adapter;
    
    /**
     *
     */
    protected int columnCount = 1;
    
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WorkListFragment() {
    
    }
    
    /**
     * @param columnCount
     *
     * @return
     */
    @SuppressWarnings("unused")
    public static WorkListFragment newInstance(int columnCount) {
        
        WorkListFragment fragment = new WorkListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }
    
    /**
     * @return
     */
    protected int getColumnCount() {
        
        return columnCount;
    }
    
    /**
     * @param mColumnCount
     */
    protected void setColumnCount(int mColumnCount) {
        
        this.columnCount = mColumnCount;
    }
    
    /**
     * @return
     */
    protected WorkAdapter getAdapter() {
        
        return adapter;
    }
    
    /**
     * @param adapter
     */
    protected void setAdapter(WorkAdapter adapter) {
        
        this.adapter = adapter;
    }
    
    /**
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        
        super.onAttach(context);
    }
    
    /**
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            setColumnCount(getArguments().getInt(ARG_COLUMN_COUNT));
        }
    }
    
    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     *
     * @return
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_work_list, container, false);
        adapter = new WorkAdapter(workOnClickCallback);
        Context context = binding.getRoot().getContext();
        if (columnCount <= 1) {
            binding.listWork.setLayoutManager(new LinearLayoutManager(context));
        } else {
            binding.listWork.setLayoutManager(new GridLayoutManager(context, columnCount));
        }
        binding.listWork.setAdapter(adapter);
        binding.swipeRefreshLayout.setOnRefreshListener(this);
        return binding.getRoot();
    }
    
    /**
     * Called when the fragment's activity has been created and this
     * fragment's view hierarchy instantiated.  It can be used to do final
     * initialization once these pieces are in place, such as retrieving
     * views or restoring state.  It is also useful for fragments that use
     * {@link #setRetainInstance(boolean)} to retain their instance,
     * as this skillOnClickCallback tells the fragment when it is fully associated with
     * the new activity instance.  This is called after {@link #onCreateView}
     * and before {@link #onViewStateRestored(Bundle)}.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        
        super.onActivityCreated(savedInstanceState);
        final WorkListViewModel _model = ViewModelProviders.of(this).get(WorkListViewModel.class);
        binding.setWorkListViewModel(_model);
        _model.getWorks().observe(this, pWorkEntities -> {
            if (pWorkEntities != null) {
                adapter.setWorkList(pWorkEntities);
            } else {
            }
            binding.executePendingBindings();
        });
    }
    
    /**
     *
     */
    @Override
    public void onDetach() {
        
        super.onDetach();
    }
    
    @Override
    public void top() {
        
        binding.listWork.smoothScrollToPosition(0);
    }
    
    @Override
    public void onRefresh() {
        
        binding.swipeRefreshLayout.setRefreshing(false);
    }
}
