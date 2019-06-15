1 获取整个交易的信息

method：GET
url: http://localhost:8081/transactions/getTransactions


resonse:
````json
   [
    {
        "blockhash": "0x001602d970831791dfee74891487805f441d4d25581fadc90a1b6ff06c5a5795",
        "time": 2019-06-15 14:55:10,
        "amounte": 0.12000000,
        "amountu": 31.89
    },
    {
        "blockhash": "0x056b38709539e60dea00c8dec89f2546ea3f57a1b48f992deac871f3c11d4117",
        "time": 2019-06-15 14:55:10,
        "amounte": 0.46000000,
        "amountu": 122.74
    }
]

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    blockhash|   String |  区块hash |
|    height|   time |  当前的时间 |
|    amounte|   Double |  去换的量 |
|    amountu|   Double |  金钱的量 |







