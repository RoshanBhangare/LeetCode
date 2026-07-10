class Solution {
public:
    vector<vector<int>> ans;

    void backtrack(vector<int>& nums, vector<int>& subset, int start) {
        ans.push_back(subset);

        for (int i = start; i < nums.size(); i++) {
            subset.push_back(nums[i]);        
            backtrack(nums, subset, i + 1);    
            subset.pop_back();                 
        }
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> subset;
        backtrack(nums, subset, 0);
        return ans;
    }
};