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

package com.alaskalany.careershowcase.ui.contact;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentContactListBinding;
import com.alaskalany.careershowcase.ui.ScrollToTop;
import com.alaskalany.careershowcase.viewmodel.ContactListViewModel;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class ContactListFragment
        extends Fragment
        implements ScrollToTop {

    /**
     *
     */
    protected static final String ARG_COLUMN_COUNT = "column-count";

    /**
     *
     */
    private final ContactOnClickCallback contactOnClickCallback =
            item -> Toast.makeText(getContext(), "Clicked on ContactEntity Item", Toast.LENGTH_SHORT)
                         .show();

    /**
     *
     */
    protected FragmentContactListBinding binding;

    /**
     *
     */
    protected ContactAdapter adapter;

    /**
     *
     */
    protected int columnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ContactListFragment() {

    }

    /**
     * @param columnCount
     *
     * @return
     */
    @SuppressWarnings("unused")
    public static ContactListFragment newInstance(int columnCount) {

        ContactListFragment fragment = new ContactListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
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

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_list, container, false);
        setAdapter(new ContactAdapter(contactOnClickCallback));
        Context context = binding.getRoot()
                                 .getContext();
        if (getColumnCount() <= 1) {
            binding.listContact.setLayoutManager(new LinearLayoutManager(context));
        } else {
            binding.listContact.setLayoutManager(new GridLayoutManager(context, getColumnCount()));
        }
        binding.listContact.setAdapter(getAdapter());
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
        final ContactListViewModel _model = ViewModelProviders.of(this)
                                                              .get(ContactListViewModel.class);
        binding.setContactListViewModel(_model);
        _model.getContacts()
              .observe(this, contactEntities -> {
                  if (contactEntities != null) {
                      adapter.setContactList(contactEntities);
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
    protected ContactAdapter getAdapter() {

        return adapter;
    }

    /**
     * @param adapter
     */
    protected void setAdapter(ContactAdapter adapter) {

        this.adapter = adapter;
    }

    @Override
    public void top() {

        binding.listContact.smoothScrollToPosition(0);
    }
}
