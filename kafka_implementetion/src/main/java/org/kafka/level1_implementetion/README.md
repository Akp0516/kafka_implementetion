# 📦 Kafka Implementation

Let's start with the basics of **Apache Kafka** in a simple and easy-to-follow way.

---

# 🚀 Kafka 4.0.0 (KRaft Mode) Setup Guide

This guide walks you through setting up **Apache Kafka 4.0.0 (KRaft mode)** — which does **not use ZooKeeper** — and demonstrates creating a topic and testing Java Producer and Consumer clients.

---

## ✅ Requirements

- Java 8+ (JDK)
- macOS/Linux (tested on macOS)
- Apache Kafka 4.0.0 (Scala 2.13)
- Terminal access

---

## 🧰 Step 1: Download and Extract Kafka

1. Download Kafka from the [official website](https://kafka.apache.org/downloads)
2. Select **Kafka 4.0.0 (Scala 2.13)**
3. Extract the archive:

```bash
cd ~/Downloads
tar -xzf kafka_2.13-4.0.0.tgz
cd kafka_2.13-4.0.0
```

## ⚙️ Step 2: Configure Kafka (KRaft mode)

### Option 1: Using Terminal

Create the configuration file:

```bash
mkdir -p config/kraft
nano config/kraft/server.properties
```

Paste the server.properties file content.



### Option 2: Manually via File Explorer

1. Navigate to: `kafka_2.13-4.0.0/config`
2. Create a new folder: `kraft` (if it doesn't exist)
3. Inside kraft, create a file named `server.properties`
4. Paste the server.properties file content

## 🧼 Step 3: Format Kafka Storage and Start Broker

```bash
bin/kafka-storage.sh format -t $(bin/kafka-storage.sh random-uuid) -c config/kraft/server.properties
bin/kafka-server-start.sh config/kraft/server.properties
```

Keep this terminal open — Kafka is now running.

## 📡 Step 4: Create a Topic

Open a new terminal in the same folder:

```bash
bin/kafka-topics.sh --create \
  --topic my-topic \
  --bootstrap-server localhost:9092 \
  --partitions 1 \
  --replication-factor 1
```

Verify it:

```bash
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

## ☕ Step 5: Java Producer & Consumer (Optional)

Compile and run Java code to send/receive Kafka messages. (See full example in separate Java files.)

## ✅ Done!

Kafka is now up and running using KRaft mode!