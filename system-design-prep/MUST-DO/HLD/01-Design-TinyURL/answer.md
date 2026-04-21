# TinyURL System Design (HLD)

## 🎯 Problem Statement
Design a URL shortening service like TinyURL that:
- Converts long URLs into short URLs
- Redirects users to original URLs
- Handles high read traffic with low latency

---

## 🧠 1. Requirements

### Functional Requirements
- Shorten long URL → short URL
- Redirect short URL → original URL
- Optional:
  - Custom alias
  - Expiry time

### Non-Functional Requirements
- Low latency (<50ms)
- High availability
- Scalable (millions of users)
- Read-heavy system

---

## 📊 2. Capacity Estimation

- ~100M URLs/month
- ~1B redirects/month (10:1 read/write)
- Avg URL size ≈ 500 bytes

### Storage
- ~50GB/year

👉 Conclusion:
- System is **read-heavy**
- Needs **fast lookup + caching**

---

## ⚙️ 3. High-Level Architecture

### Components
- Load Balancer
- API Service
- Key Generation Service
- Database (URL Mapping)
- Cache (Redis)
- CDN (optional)

---

## 🔄 4. Core Flows

### ➤ URL Shortening (Write Flow)
1. Receive long URL
2. Generate unique ID
3. Encode ID → Base62 → shortKey
4. Store in DB
5. Return short URL

---

### ➤ URL Redirect (Read Flow)
1. User hits short URL
2. Check Redis cache
3. If cache miss → query DB
4. Return HTTP 302 redirect
5. Cache result

---

## 🔑 5. Key Generation Strategy

### ✅ Base62 Encoding (Recommended)

- Characters: `[a-zA-Z0-9]`
- Convert unique numeric ID → short string

Example:
125 → "cb"


### ✔️ Advantages
- No collision
- Short and URL-friendly
- Fast

### ❌ Alternatives
- Hash (MD5/SHA) → collision risk
- Random → retry logic needed

---

## 🧱 6. Database Design

```sql```
CREATE TABLE url_mapping (
  id BIGINT PRIMARY KEY,
  short_key VARCHAR(10) UNIQUE,
  long_url TEXT,
  created_at TIMESTAMP,
  expiry TIMESTAMP
);

