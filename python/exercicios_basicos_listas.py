def f (a, b):
    return a + b

def max_list(lista):
    #max(lista)
    max_v = 0
    for l in lista:
        if(max_v < l):
            max_v = l
    return max_v


#[1,3,4]
def sort(lista):
    min_v = lista[0]
    for i in range(1, len(lista)):
        for j in range(1, len(lista)):
            if(min_v > lista[i]): 
                aux = lista[i]
                lista[j] = min_v
                min_v = aux
    return lista


