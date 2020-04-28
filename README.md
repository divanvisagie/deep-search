# Input data

The input data should look like the following

```json
{
  "name": "Pablo",
  "version": 1.6,
  "object": {
    "should_process": true,
    "value": 1
  },
  "objectlayer1": {
    "objectlayer2": {
      "should_process": false,
      "value": 2
    },
    "objectlayer3": {
      "should_process": true,
      "value":  3
    }
  }

}
```

The program should process the object without regard to the depth and only retreive the values form the objects 
marked as *should_process*. The result for the sum of processed values should therefore in this case be 4
