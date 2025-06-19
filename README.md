# eselisto

# 🧳 eselisto – Smart Multi-User Packing List Management System

**eselisto** is a powerful, flexible, and user-centric application for managing packing lists for vacations, trips, outdoor adventures, and more. Designed for both individuals and shared environments, eselisto helps you organize what to take, where it goes, and what still needs attention — so nothing gets left behind.

---

## 🚀 Features

- ✅ **Multi-user support**  
  Each user has private categories, items, and trips. All data is securely scoped.

- 🧳 **Powerful packing lists**  
  Plan exactly what you need for each trip, with quantities, units, reminders, and packing status.

- 🗃️ **Hierarchical nesting of items**  
  Model realistic packing like _passport → wallet → backpack → suitcase_ using item-to-item containment.

- 🔁 **Reusable item catalog**  
  Maintain a centralized catalog of items, assign categories, and reuse them across multiple trips.

- ⚙️ **Task and check system**  
  Add packing to-dos and _last-minute check_ flags to individual items.

- 🏷️ **Categories, tags, priorities**  
  Filter and sort items by type, tag (e.g., `wifi`, `gift`, `hiking`) or importance (e.g., `ESSENTIAL`).

- 📦 **Track consumables & containers**  
  Identify whether items are used up (e.g., batteries) or can hold others (e.g., a toiletry bag).

- 📸 **Visual catalog**  
  Attach images to your items for quick visual recognition.

---

## 📐 Project Structure

eselisto is built on a structured, relational data model and exposes a RESTful API.

### 📊 Data Model Highlights

- All entities use UUIDs for distributed uniqueness
- Core tables: `user`, `vacation`, `item`, `category`, `packlist`, `nesting`
- Timestamped entries for auditing and synchronization
- Logical constraints (no cyclic nesting, quantity validation, etc.)

### 📡 Planned REST API

Modular, versioned endpoints (`/api/v1/...`) including:

- User registration and profile
- CRUD for trips, items, categories
- Add/remove items to/from packing lists
- Manage nested containers (bags within bags)
- Mark items as packed, add last-check flags
- Export trips or item stats

---

## 💡 Use Cases

- Plan trips with detailed packing lists  
- Track what’s packed and what’s pending  
- Share packing logic with others (coming soon)  
- Model realistic item nesting (e.g., gear in bags)  
- Track consumables and replacements  
- Keep item history and inventory active/inactive  

---

## 🧠 Technology Stack (planned)

- Java
- JPA (Hibernate) with MariaDB
- RESTful API (OpenAPI 3.0)
- Optional frontend (Vue/React)
- JSON-based client communication
- Authentication via OAuth2 or JWT

---



<a href="https://github.com/MichaH/eselisto">eseListo</a> © 2025 by <a href="https://www.michaelhofmann.net/">Michael Hofmann</a> is licensed under <a href="https://creativecommons.org/licenses/by-nd/4.0/">Creative Commons Attribution-NoDerivatives 4.0 International</a><br><br>
<img src="https://mirrors.creativecommons.org/presskit/icons/cc.svg" style="max-width: 1em;max-height:1em;margin-left: .2em;"><img src="https://mirrors.creativecommons.org/presskit/icons/by.svg" style="max-width: 1em;max-height:1em;margin-left: .2em;"><img src="https://mirrors.creativecommons.org/presskit/icons/nd.svg" style="max-width: 1em;max-height:1em;margin-left: .2em;">
