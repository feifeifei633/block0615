1 根据区块高度获取区块详情

method：GET
url: /block/getByHeight?height={height}

resonse:
````json
    {
        "blockhash":"000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "height": 580769,
         "previousblock": "00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd",
          "nextblock": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "time": "2019-06-15T08:28:23.750+0000",
        "txsize": 2390,
        "size": 1773,
        "Difficulty":7409399249090.25
    }

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    time|   Long |  出块时间 |
|    txsize|   Short |  交易数量 |
|    size|   Integer |  区块大小 |
|    previousblock|   String |  前一个区块 |
|    nextblock|   String |  后一个区块 |
|    difficulty|   Double |  困难程度 |


2 根据区块hash获取区块详情

method：GET
url: /block/getByBlockhash?getByBlockhash={getByBlockhash}

resonse:
````json
    {
        "blockhash":"000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "height": 580769,
         "previousblock": "00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd",
          "nextblock": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "time": "2019-06-15T08:28:23.750+0000",
        "size": 1773,
        "Difficulty":7409399249090.25
    }

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    time|   Long |  出块时间 |
|    txsize|   Short |  交易数量 |
|    size|   Integer |  区块大小 |
|    previousblock|   String |  前一个区块 |
|    nextblock|   String |  后一个区块 |
|    difficulty|   Double |  困难程度 |



3 获取当前最新区块

method：GET
url: /block/getRecentBlocks

resonse:
````json
   [
    {
        "blockhash": "000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb",
        "height": 580769,
        "stime": "2019-06-15T08:28:23.750+0000",
        "numberoftransactions": 2390,
        "size": 1773,
        "Txsize":2390
    },
    {
        "blockhash": "00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b",
        "height": 580643,
        "stime": "2019-06-15T08:28:23.750+0000",
        "numberoftransactions": 2702,
        "size": 1322496,
        "Txsize":2702
    }
]

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    time|   Long |  出块时间 |
|    txsize|   Short |  交易数量 |
|    size|   Integer |  区块大小 |
|    previousblock|   String |  前一个区块 |
|    nextblock|   String |  后一个区块 |
|    difficulty|   Double |  困难程度 |







