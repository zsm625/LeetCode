class MaxArea {
    public int maxArea(int[] height) {
        
        int length = height.length;

        int l = 0;
        int r = length - 1;
        int maxArea = 0;
        while (l < r) {

            if (height[l] > height[r]) {
                int temp_height = height[r];
                int tempArea = (r - l) * temp_height;
                if (maxArea < tempArea) {
                    maxArea = tempArea;
                }
                do {
                    r--;
                } while(l < r && !(height[r] > temp_height));
            } else {
                int temp_height = height[l];
                int tempArea = (r - l) * temp_height;
                if (maxArea < tempArea) {
                    maxArea = tempArea;
                }
                do {
                    l++;
                } while(l < r && !(height[l] > temp_height));
            }
        }

        return maxArea;
    
    }
}
