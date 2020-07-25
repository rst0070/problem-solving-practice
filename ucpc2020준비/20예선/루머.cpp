#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int N, M, temp, totalTime;
vector<int> Node[200'001];
vector<int> primaryNode;
vector<int> timeOfThem;
bool visited[200'001];
bool isOK(int next)
{
    int everyOne = (Node[next].size());
    int believeCnt = 0;
    for (auto near : Node[next])
    {
        if (visited[near])
        {
            believeCnt += 1;
            if (2*believeCnt >= (everyOne))
            {
                return true;
            }
        }
    }
    return false;
}
void BFS()
{
    queue<int> Q;
    queue<int> Qtemp, Qtemp2;
    //queue<pair<int, int>> Qlast;
    for (int i = 0; i < M; i++)
    {
        Q.push(primaryNode[i]);
        visited[primaryNode[i]] = true;
    }

    bool changed = false;
    while (!Q.empty())
    {
        changed = false;
        int currsizeQ = Q.size();
        for (int i = 0; i < currsizeQ; i++)
        {
            int now = Q.front();
            if(timeOfThem[now] == -1)   timeOfThem[now] = totalTime;
            Qtemp2.push(now);
            Q.pop();
            for (auto next : Node[now])
            {
                if (!visited[next] && isOK(next))
                {
                    Qtemp.push(next);
                }
            }

            while (!Qtemp.empty())
            {
                int nowNode = Qtemp.front();
                Qtemp.pop();
                Q.push(nowNode);
                visited[nowNode] = true;
            }

            
        }
        if(!changed) break;

        while(!Qtemp2.empty()){
            Q.push(Qtemp2.front());
            Qtemp2.pop();
        }
        totalTime += 1;
    }
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N;
    timeOfThem.resize(N + 1);
    for (int i = 0; i <= N; i++)
    {
        timeOfThem[i] = -1;
    }
    for (int i = 1; i <= N; i++)
    {
        while (true)
        {
            cin >> temp;
            if (temp != 0)
            {
                Node[i].push_back(temp);
            }
            else
            {
                break;
            }
        }
    }
    cin >> M;
    for (int i = 0; i < M; i++)
    {
        cin >> temp;
        primaryNode.push_back(temp);
    }
    BFS();
    for (int i = 1; i <= N; i++)
    {
        if (i != N)
            cout << timeOfThem[i] << ' ';
        else
            cout << timeOfThem[i];
    }
    return 0;
}