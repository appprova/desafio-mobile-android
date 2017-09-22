package net.hugonardo.gjp.repos;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import net.hugonardo.gjp.R;
import net.hugonardo.gjp.api.repo.Repo;
import net.hugonardo.gjp.databinding.RepoListItemBinding;

import java.util.List;

public class RepoListAdapter extends RecyclerArrayAdapter<Repo> {

    private final Object mLocker = new Object();
    private final LayoutInflater mLayoutInflater;
    private final EventHandler mEventHandler;

    public interface EventHandler {
        void onItemClick(Repo repo);
    }

    RepoListAdapter(LayoutInflater layoutInflater, EventHandler eventHandler) {
        super(null);
        mLayoutInflater = layoutInflater;
        mEventHandler = eventHandler;
    }

    void swapData(List<Repo> newDataset) {
        if (mEventDelegate != null) {
            if (newDataset != null && !newDataset.isEmpty() && ((newDataset.size() - getCount()) > 0)) {
                mEventDelegate.addData(newDataset.size() - getCount());
            }
        }

        if (newDataset != null && newDataset.size() != 0) {
            synchronized (mLocker) {
                mObjects = newDataset;
            }
            notifyDataSetChanged();
        } else {
            clear();
        }
    }

    @Override public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        RepoListItemBinding binding = DataBindingUtil.inflate(mLayoutInflater,
                R.layout.repo_list_item, parent, false);
        binding.setHandler(mEventHandler);
        return new RepoViewHolder(binding);
    }
}
