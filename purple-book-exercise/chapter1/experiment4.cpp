#include <stdio.h>

int main() {

    // 输出0.0 https://www.zhihu.com/question/55152080
    printf("%.1f\n", 8);

    // 输出1.6
    printf("%.1f\n", (float)8/5);

    // 输出1.0
    printf("%.1f\n", (float)(8/5));

    // 输出1.6
    printf("%.1f\n", 8/5.0);

    return 0;
}


