#include <stdio.h>
//#include <conin.h>
#include <unistd.h>
#define cycle 5
//#ifdef _win32
#define sleep(x) Sleep(x*1000)
#define clrscr() printf("\e[1;1H\e[2J")


int main(){
    int hour, minute, second;
    printf("enter Hour Minute Second : ");
    scanf("%d%d%d", &hour, &minute, &second);
    clrscr();

    
    int i, h = 0, m = 0, s = 0;
    while (i){
        printf("\n\n####### STOP WATCH ######\n\n\n");
        printf("        %.2d:%.2d:%.2d", h, m, s);
        if(h == hour && m == minute && s == second){
            break;
        }
            
        else{
            clrscr();
        }
        s++;
        sleep(1);
        if(s == cycle){
            m++;
            s = 0;
        }
        if(m == cycle){
            h++;
            m == 0;
        }
    }
return 0;
}

