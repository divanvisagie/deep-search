#! ./env/bin/python

import greeter
import json

def get_valid_objects(o):
    valids = []

    if type(o) is dict:
        if 'should_process' in o and o['should_process'] == True:
            valids.append(o)
        else:
            print(f'- {o} is a dict')
            for k in o:
                v = o[k]
                m = get_valid_objects(v)
                valids.extend(m)
    
    if type(o) is list:
        print(f'- {o} is a list')
        for i in o:
            m = get_valid_objects(i)
            valids.extend(m)
    
    return valids

def sumOf(o):
    vo = get_valid_objects(o)
    print(vo)
    values = map(lambda x: int(x['value']), vo)
    return sum(list(values))

def main():
    with open('sample.json', 'r') as json_file:
        parsed = json.load(json_file)
        print(f'loaded json {parsed}')
        print(f'sum: {sumOf(parsed)}')
    
if __name__ == "__main__":
    main()



