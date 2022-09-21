#include<iostream>
#include<algorithm>

using namespace std;
typedef struct Point{
    long long x, y;
}Point;
typedef struct Line{
    Point p, q;
}Line;

void arrangeLine(Line* line){
    Point* p = &(line->p);
    Point* q = &(line->q);
    if(p->x == q->x){

        return;
    }
}

/**
 * (ry - py)/(rx - px) : (qy - py)/(qx - px)
 * : == > -  반시계
 * 
 * @return 1 - 반시계, -1 - 시계, 0 - 일직선
 */
int orientation(Point* p, Point* q, Point* r){
    long long val = (r->y - p->y)*(q->x - p->x) - (q->y - p->y)*(r->x - p->x);
    if(val > 0) return 1;
    if(val < 0) return -1;
    return 0;
}

/**
 * @brief p와 q사이에 r이 있고 이 3점이 일직선을 이루는가?
 * @param p 
 * @param q 
 * @param r 
 * @return true 
 * @return false 
 */
bool onSegment(Point* p, Point* q, Point* r){
    if(r->x <= max(p->x, q->x) && r->x >= min(p->x, q->x)
    && r->y <= max(p->y, q->y) && r->y >= min(p->y, q->y)) return true;
    return false;
}

/**
 * @brief 
 * ccw와 좌표간 겹침을 고려해서 구현해야함.
 * 
 * @param line1 
 * @param line2 
 * @return int 
 */
int is_intersact(Line line1, Line line2){
    int pqr = orientation(&(line1.p), &(line1.q), &(line2.p));
    int pqs = orientation(&(line1.p), &(line1.q), &(line2.q));
    int rsp = orientation(&(line2.p), &(line2.q), &(line1.p));
    int rsq = orientation(&(line2.p), &(line2.q), &(line1.q));

    if(pqr != pqs && rsp != rsq) return true;

    if(pqr == 0 && onSegment(&line1.p, &line1.q, &line2.p)) return true;
    if(pqs == 0 && onSegment(&line1.p, &line1.q, &line2.q)) return true;
    if(rsp == 0 && onSegment(&line2.p, &line2.q, &line1.p)) return true;
    if(rsq == 0 && onSegment(&line2.p, &line2.q, &line1.q)) return true;

    return false;
}

int main(){
    Line line1, line2;
    long long px, py, qx, qy, rx, ry, sx, sy;
    cin >> line1.p.x >> line1.p.y >> line1.q.x >> line1.q.y;
    cin >> line2.p.x >> line2.p.y >> line2.q.x >> line2.q.y;

    cout << is_intersact(line1, line2) << endl;

    return 0;
}