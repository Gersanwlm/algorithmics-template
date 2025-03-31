import json

from helper import draw_coloured_map, generate_graph_map


def greedy(graph):
    colors={}
    available_colors= ["red", "blue", "green", "yellow","orange", "purple", "cyan", "magenta", "lime"]

    sorted_nodes=sorted(graph.keys(), key=lambda node: len(graph[node]),reverse=True) #Sort nodes by degree

    for node in sorted_nodes:
        used_colors=[]
        #Get color of neighbours
        for neighbor in graph[node]: #Get each neighbour's color and check if it has been used
            neighbor_color = str(neighbor)
            if neighbor_color in colors:
                used_colors.append(colors[neighbor_color]) 

        for color in available_colors: #Assign the first non-used color to the node
            if color not in used_colors:
                colors[str(node)]=color
                break
    return colors




if __name__ == "__main__":
    n = 16
    map = generate_graph_map(n)
    solution = greedy(map["graph"])

    if solution:
        print("Solution found:", solution)
        draw_coloured_map(map, solution)
        with open('solution.json', 'w') as f:
            json.dump(solution, f)
            f.close()
    else:
        print("Solution not found.")
