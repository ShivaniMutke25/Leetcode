# 🎯 TinyURL System Design – Interview Answer

## 🧠 Approach

I will structure my solution as follows:
1. Requirements
2. Capacity Estimation
3. High-Level Design
4. Deep Dive (Key Components)
5. Challenges & Solutions
6. Tradeoffs

---

## 🧩 1. Requirements

### Functional
- Shorten long URL → short URL  
- Redirect short URL → original URL  
- Optional:
  - Custom alias  
  - Expiry  

### Non-Functional
- Low latency (<50ms)
- High availability
- Scalable system
- Read-heavy workload

---

## 📊 2. Capacity Estimation

- ~100M URLs/month  
- ~1B redirects/month (10:1 read/write)  

👉 This is a **read-heavy system**, so optimization should focus on fast reads.

---

## ⚙️ 3. High-Level Design

### Components
- Load Balancer  
- API Service  
- Key Generation Service  
- Database (URL mapping)  
- Cache (Redis)  

---

## 🔄 4. Core Flows

### ➤ Write Flow (Shorten URL)
1. User sends long URL  
2. Generate unique ID  
3. Encode ID → Base62 → shortKey  
4. Store mapping in DB  
5. Return short URL  

---

### ➤ Read Flow (Redirect)
1. User hits short URL  
2. Check Redis cache  
3. If cache miss → query DB  
4. Return HTTP 302 redirect  
5. Cache result  

---

## 🔑 5. Deep Dive

### Key Generation
- Use Base62 encoding on unique ID  
- Ensures:
  - No collisions  
  - Short URLs  
  - Fast generation  

---

### Caching Strategy
- Redis:
shortKey → longURL
- Cache hot URLs  
- Use TTL for inactive links  

👉 Goal: Reduce DB load and latency  

---

## 🚨 6. Challenges & Solutions

### Hot URLs (Viral Traffic)
- Use aggressive caching  
- Use CDN  

### Latency
- Cache-first approach  

### Scalability
- DB sharding  
- Read replicas  

### Abuse (Spam)
- Rate limiting  
- Input validation  

---

## ⚖️ 7. Tradeoffs

| Decision        | Choice        | Reason                  |
|----------------|--------------|--------------------------|
| Key Generation | Base62       | No collision, efficient  |
| Cache vs DB    | Cache-first  | Low latency              |
| Consistency    | Eventual     | Faster reads             |

---

## 🎯 8. Final Summary

Design a read-optimized URL shortening system using:
- Base62-encoded unique IDs  
- Distributed database  
- Redis caching  

Focus on:
- Low latency  
- High scalability  
- Efficient read handling  

---

## 💡 Key Insight

> Writes are rare, reads are massive → optimize for reads.
