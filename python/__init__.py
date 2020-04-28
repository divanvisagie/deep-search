#! ./env/bin/python

import json

def get_valid_objects(o):
    valids = []

    if type(o) is dict:
        if 'should_process' in o and o['should_process'] == True:
            valids.append(o)
        else:
            for k in o:
                v = o[k]
                m = get_valid_objects(v)
                valids.extend(m)
    
    if type(o) is list:
        for i in o:
            m = get_valid_objects(i)
            valids.extend(m)
    
    return valids

def sum_search(json_string):
    o = json.load(json_string)
    vo = get_valid_objects(o)
    values = map(lambda x: int(x['value']), vo)
    return sum(list(values))

def main():
    with open('sample.json', 'r') as json_file:
        print(f'sum: {sum_search(json_file)}')
    
if __name__ == "__main__":
    main()



