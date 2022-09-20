#include<iostream>
using namespace std;

/**
 * @brief 
 * https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/?ref=lbp 참고
 * 
 */

typedef struct Point{
    int x, y;
}Point;

typedef struct Line{
    Point p;
    Point q;
}Line;

int N;
Line lines[3000];
int parent[3000];
int grouop_size[3000] = {0};


/**
 * @brief pqr이 일직선상에 있는가?
 * 이때 p와 r사이에 q가 있어야 한다.
 * @param p 
 * @param q 
 * @param r 
 * @return true 
 * @return false 
 */
bool onSegment(Point p, Point q, Point r){
    if (q.x <= max(p.x, r.x) && q.x >= min(p.x, r.x) &&
        q.y <= max(p.y, r.y) && q.y >= min(p.y, r.y))
       return true;
    return false;
}

/**
 * @brief 
 * 
 * @param p 
 * @param q 
 * @param r 
 * @return int - -1 시계, 1 반시계, 0 일직선 
 */
int orientation(Point p, Point q, Point r){
    int val = (r.y - p.y)*(q.x - p.x) - (q.y - p.y)*(r.x - p.x);
    if(val > 0) return 1;
    if(val < 0) return -1;
    return val;
}

/**
 * @brief
 * 
 * @param l1 - p와 q를 끝점으로 가지는 선
 * @param l2 - r과 s를 끝점으로 가지는 선
 * @return true 
 * @return false 
 */
bool intersact(Line* l1, Line* l2){
    int pqr = orientation(l1->p, l1->q, l2->p);
    int pqs = orientation(l1->p, l1->q, l2->q);
    int rsp = orientation(l2->p, l2->q, l1->p);
    int rsq = orientation(l2->p, l2->q, l1->q);

    if(pqr != pqs && rsp != rsq) return true;

    if(pqr == 0 && onSegment(l1->p, l2->p, l1->q)) return true;
    if(pqs == 0 && onSegment(l1->p, l2->q, l1->q)) return true;
    if(rsp == 0 && onSegment(l2->p, l1->p, l2->q)) return true;
    if(rsq == 0 && onSegment(l2->p, l1->q, l2->q)) return true;

    return false;
}

int find(int l){
    if(l == parent[l]) return l;
    return find(parent[l]);
}

void uni(int l1, int l2){
    l1 = find(l1);
    l2 = find(l2);

    if(l1 == l2) return;

    if(l1 < l2){
        parent[l2] = l1;
        grouop_size[l1] += grouop_size[l2];
        grouop_size[l2] = 0;
        return;
    }
    parent[l1] = l2;
    grouop_size[l2] += grouop_size[l1];
    grouop_size[l1] = 0;
}

int main(){

    cin >> N;
    for(int i = 0; i < N; i++){
        parent[i] = i;
        grouop_size[i] = 1;
        Line line;
        cin >> line.p.x >> line.p.y >> line.q.x >> line.q.y;
        lines[i] = line;

        for(int j = i - 1; j >= 0; j--){
            if(intersact(&lines[i], &lines[j]))
                uni(i, j);
        }
    }

    int count = 0;
    int maxSize = 0;
    for(int i = 0; i < N; i++){
        if(parent[i] == i) count++;
        maxSize = maxSize > grouop_size[i] ? maxSize : grouop_size[i];
    }
        
    cout << count << endl << maxSize;

    return 0;
}