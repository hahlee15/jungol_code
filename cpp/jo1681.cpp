#include <iostream>

using namespace std;
int N = 0, best = 987654321;
int map[12][12];
bool visit[12];

void findMin(int s, int cnt, int Ncnt){
    if(Ncnt == N){
        if(map[s][0] == 0)
            return;
        else{
            cnt += map[s][0];
            if(best > cnt)
                best = cnt;
            return;
        }
    }

    for(int i = 1; i < N; i++){
        if(cnt > best)
            return;

        if((map[s][i] != 0) && (visit[i] == false)){
            visit[i] = true;
            findMin(i, cnt+map[s][i], Ncnt+1);
            visit[i] = false;
        }
    }
}


int main(void){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            scanf(" %d", &map[i][j]);
        }
    }

    findMin(0, 0, 1);
    printf("%d\n", best);

    return 0;
}