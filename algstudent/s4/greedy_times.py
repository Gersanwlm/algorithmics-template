import json
import graph_colouring
from time import time


i=8
while(i<=65536):
    with open('sols/g'+str(i)+'.json', 'r') as f:
        map = json.load(f)
        f.close()
    reps=1000
    t1=time()
    for j in range(reps):
        solution=graph_colouring.greedy(map["graph"])
    t2=time()
    print(f"n={i}\tTime:{(t2-t1)*1000} miliseconds")
    i*=2




