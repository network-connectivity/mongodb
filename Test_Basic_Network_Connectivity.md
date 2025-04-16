# Test Basic Network Connectivity for MongoDB Atlas

## 1. Determine which connection string formats are being used.

The SRV URI connection scheme has the following form:
```sh
mongodb+srv://[username:password@]host[/[defaultauthdb][?options]]
```
example:
```sh
mongodb+srv://user1:pwduser1@cluster0.xxxxx.mongodb.net/<dbname>?w=majority
```

## 2. Resolve a DNS SRV record

```sh
nslookup -debug -q=SRV  _mongodb._tcp.<host>
```

example:
```sh
nslookup -debug -q=SRV  _mongodb._tcp.cluster0.xxxxx.mongodb.net
```

The output should provide a server list that includes information such as IP addresses, server names, and hosts, similar to this
```sh
Non-authoritative answer:
_mongodb._tcp.cluster0.xxxxx.mongodb.net     SRV service location:
          priority=0, weight=5, port=27017, server=node1.cluster0.xxxxx.mongodb.net
          priority=0, weight=5, port=27017, server=node2.cluster0.xxxxx.mongodb.net
          priority=0, weight=5, port=27017, server=node3.cluster0.xxxxx.mongodb.net
```

## 3. Use the telnet or nc command to test connectivity to each server in the cluster

```sh
nc -zv <Server Hostname> <Server Port Number>

telnet <Server Hostname> <Server Port Number>
```

example:
```sh
nc -zv node2.cluster0.xxxxx.mongodb.net 27017

telnet node2.cluster0.xxxxx.mongodb.net 27017
```
