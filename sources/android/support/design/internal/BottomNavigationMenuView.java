package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.v4.util.Pools;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    private final int mActiveItemMaxWidth;
    private final BottomNavigationAnimationHelperBase mAnimationHelper;
    private BottomNavigationItemView[] mButtons;
    private final int mInactiveItemMaxWidth;
    private final int mInactiveItemMinWidth;
    private int mItemBackgroundRes;
    private final int mItemHeight;
    private ColorStateList mItemIconTint;
    private final Pools.Pool<BottomNavigationItemView> mItemPool;
    private ColorStateList mItemTextColor;
    /* access modifiers changed from: private */
    public MenuBuilder mMenu;
    private final View.OnClickListener mOnClickListener;
    /* access modifiers changed from: private */
    public BottomNavigationPresenter mPresenter;
    private int mSelectedItemId;
    private int mSelectedItemPosition;
    private boolean mShiftingMode;
    private int[] mTempChildWidths;

    public BottomNavigationMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mItemPool = new Pools.SynchronizedPool(5);
        this.mShiftingMode = true;
        this.mSelectedItemId = 0;
        this.mSelectedItemPosition = 0;
        Resources res = getResources();
        this.mInactiveItemMaxWidth = res.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.mInactiveItemMinWidth = res.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.mActiveItemMaxWidth = res.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.mItemHeight = res.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        if (Build.VERSION.SDK_INT >= 14) {
            this.mAnimationHelper = new BottomNavigationAnimationHelperIcs();
        } else {
            this.mAnimationHelper = new BottomNavigationAnimationHelperBase();
        }
        this.mOnClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                MenuItem item = ((BottomNavigationItemView) v).getItemData();
                if (!BottomNavigationMenuView.this.mMenu.performItemAction(item, BottomNavigationMenuView.this.mPresenter, 0)) {
                    item.setChecked(true);
                }
            }
        };
        this.mTempChildWidths = new int[5];
    }

    public void initialize(MenuBuilder menu) {
        this.mMenu = menu;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2;
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int count = getChildCount();
        int heightSpec = View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824);
        if (this.mShiftingMode) {
            int inactiveCount = count - 1;
            int activeWidth = Math.min(width - (this.mInactiveItemMinWidth * inactiveCount), this.mActiveItemMaxWidth);
            int inactiveWidth = Math.min((width - activeWidth) / inactiveCount, this.mInactiveItemMaxWidth);
            int extra = (width - activeWidth) - (inactiveWidth * inactiveCount);
            for (int i3 = 0; i3 < count; i3++) {
                int[] iArr = this.mTempChildWidths;
                if (i3 == this.mSelectedItemPosition) {
                    i2 = activeWidth;
                } else {
                    i2 = inactiveWidth;
                }
                iArr[i3] = i2;
                if (extra > 0) {
                    int[] iArr2 = this.mTempChildWidths;
                    iArr2[i3] = iArr2[i3] + 1;
                    extra--;
                }
            }
        } else {
            if (count == 0) {
                i = 1;
            } else {
                i = count;
            }
            int childWidth = Math.min(width / i, this.mActiveItemMaxWidth);
            int extra2 = width - (childWidth * count);
            for (int i4 = 0; i4 < count; i4++) {
                this.mTempChildWidths[i4] = childWidth;
                if (extra2 > 0) {
                    int[] iArr3 = this.mTempChildWidths;
                    iArr3[i4] = iArr3[i4] + 1;
                    extra2--;
                }
            }
        }
        int totalWidth = 0;
        for (int i5 = 0; i5 < count; i5++) {
            View child = getChildAt(i5);
            if (child.getVisibility() != 8) {
                child.measure(View.MeasureSpec.makeMeasureSpec(this.mTempChildWidths[i5], 1073741824), heightSpec);
                child.getLayoutParams().width = child.getMeasuredWidth();
                totalWidth += child.getMeasuredWidth();
            }
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(totalWidth, View.MeasureSpec.makeMeasureSpec(totalWidth, 1073741824), 0), ViewCompat.resolveSizeAndState(this.mItemHeight, heightSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();
        int width = right - left;
        int height = bottom - top;
        int used = 0;
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    child.layout((width - used) - child.getMeasuredWidth(), 0, width - used, height);
                } else {
                    child.layout(used, 0, child.getMeasuredWidth() + used, height);
                }
                used += child.getMeasuredWidth();
            }
        }
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void setIconTintList(ColorStateList tint) {
        this.mItemIconTint = tint;
        if (this.mButtons != null) {
            for (BottomNavigationItemView item : this.mButtons) {
                item.setIconTintList(tint);
            }
        }
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.mItemIconTint;
    }

    public void setItemTextColor(ColorStateList color) {
        this.mItemTextColor = color;
        if (this.mButtons != null) {
            for (BottomNavigationItemView item : this.mButtons) {
                item.setTextColor(color);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.mItemTextColor;
    }

    public void setItemBackgroundRes(int background) {
        this.mItemBackgroundRes = background;
        if (this.mButtons != null) {
            for (BottomNavigationItemView item : this.mButtons) {
                item.setItemBackground(background);
            }
        }
    }

    public int getItemBackgroundRes() {
        return this.mItemBackgroundRes;
    }

    public void setPresenter(BottomNavigationPresenter presenter) {
        this.mPresenter = presenter;
    }

    public void buildMenuView() {
        boolean z;
        removeAllViews();
        if (this.mButtons != null) {
            for (BottomNavigationItemView item : this.mButtons) {
                this.mItemPool.release(item);
            }
        }
        if (this.mMenu.size() == 0) {
            this.mSelectedItemId = 0;
            this.mSelectedItemPosition = 0;
            this.mButtons = null;
            return;
        }
        this.mButtons = new BottomNavigationItemView[this.mMenu.size()];
        if (this.mMenu.size() > 3) {
            z = true;
        } else {
            z = false;
        }
        this.mShiftingMode = z;
        for (int i = 0; i < this.mMenu.size(); i++) {
            this.mPresenter.setUpdateSuspended(true);
            this.mMenu.getItem(i).setCheckable(true);
            this.mPresenter.setUpdateSuspended(false);
            BottomNavigationItemView child = getNewItem();
            this.mButtons[i] = child;
            child.setIconTintList(this.mItemIconTint);
            child.setTextColor(this.mItemTextColor);
            child.setItemBackground(this.mItemBackgroundRes);
            child.setShiftingMode(this.mShiftingMode);
            child.initialize((MenuItemImpl) this.mMenu.getItem(i), 0);
            child.setItemPosition(i);
            child.setOnClickListener(this.mOnClickListener);
            addView(child);
        }
        this.mSelectedItemPosition = Math.min(this.mMenu.size() - 1, this.mSelectedItemPosition);
        this.mMenu.getItem(this.mSelectedItemPosition).setChecked(true);
    }

    public void updateMenuView() {
        int menuSize = this.mMenu.size();
        if (menuSize != this.mButtons.length) {
            buildMenuView();
            return;
        }
        int previousSelectedId = this.mSelectedItemId;
        for (int i = 0; i < menuSize; i++) {
            MenuItem item = this.mMenu.getItem(i);
            if (item.isChecked()) {
                this.mSelectedItemId = item.getItemId();
                this.mSelectedItemPosition = i;
            }
        }
        if (previousSelectedId != this.mSelectedItemId) {
            this.mAnimationHelper.beginDelayedTransition(this);
        }
        for (int i2 = 0; i2 < menuSize; i2++) {
            this.mPresenter.setUpdateSuspended(true);
            this.mButtons[i2].initialize((MenuItemImpl) this.mMenu.getItem(i2), 0);
            this.mPresenter.setUpdateSuspended(false);
        }
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView item = this.mItemPool.acquire();
        if (item == null) {
            return new BottomNavigationItemView(getContext());
        }
        return item;
    }

    public int getSelectedItemId() {
        return this.mSelectedItemId;
    }

    /* access modifiers changed from: package-private */
    public void tryRestoreSelectedItemId(int itemId) {
        int size = this.mMenu.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = this.mMenu.getItem(i);
            if (itemId == item.getItemId()) {
                this.mSelectedItemId = itemId;
                this.mSelectedItemPosition = i;
                item.setChecked(true);
                return;
            }
        }
    }
}
