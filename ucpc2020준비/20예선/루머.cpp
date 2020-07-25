/**
 * 7
 * 2 3 0
 * 1 3 4 0
 * 1 2 0
 * 2 5 0
 * 4 0
 * 0
 * 0
 * 2
 * 1 6
 * 
 */
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
long long N, M, temp, totalTime;
double believeCnt;
vector<long long> Node[200'001];
vector<long long> primary;
vector<long long> timeOfThem;
bool visited[200'001];
bool isHeBelieve[200'001];
bool isOK(long long next)
{
    double everyOne = (double)(Node[next].size());
    believeCnt = 0.0;
    for (auto near : Node[next])
    {
        if (isHeBelieve[near])
        {
            believeCnt += 1.0;
            if (believeCnt >= (everyOne / 2.0))//2*believeCnt >= everyOne
            {
                return true;
            }
        }
    }
    return false;
}
void BFS()
{
    queue<long long> Q;
    queue<long long> Qtemp;
    for (long long i = 0; i < M; i++)
    {
        Q.push(primary[i]);
        visited[primary[i]] = true;
        isHeBelieve[primary[i]] = true;
    }
    while (!Q.empty())
    {
        long long currsizeQ = Q.size();
        for (long long i = 0; i < currsizeQ; i++)
        {
            long long now = Q.front();
            timeOfThem[now] = totalTime;
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
                long long nowNode = Qtemp.front();
                Qtemp.pop();
                Q.push(nowNode);
                visited[nowNode] = true;
                isHeBelieve[nowNode] = true;
            }
        }
        totalTime += 1;
    }
}
int main()
{
    /*ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
*/
    cin >> N;
    timeOfThem.resize(N + 1);
    fill(timeOfThem.begin(), timeOfThem.end(), -1);
    for (long long i = 1; i <= N; i++)
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
    for (long long i = 0; i < M; i++)
    {
        cin >> temp;
        primary.push_back(temp);
    }
    BFS();
    for (long long i = 1; i <= N; i++)
    {
        if (i != N)
            cout << timeOfThem[i] << ' ';
        else
            cout << timeOfThem[i];
    }
    return 0;
}