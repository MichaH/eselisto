# 📘 Packlist Database Model – Technical Documentation

This document describes the data model used in the *Packlist Management System*, a multi-user platform for planning, managing, and tracking items needed for trips and vacations.

The model supports:
- Flexible item management
- Multi-user separation
- Reusability of data
- Realistic packing structures (e.g., items inside bags)
- Task tracking for preparation
- Auditability and traceability

All core tables use UUIDs (`VARCHAR(36)`) as primary keys. Every table includes metadata fields for timestamps and system usage.

---

## 👤 `user` – The Account Holder

The `user` table stores individual accounts. All other core data (items, trips, categories) are owned by a user.

### Fields:
- `user_id`: UUID identifying a person (Primary Key).
- `user_name`: Display name for the user.
- `creation_time`: When the user was created.
- `last_change`: When the user record was last updated.
- `surrogate_key`: Internal or external reference ID.

---

## ✈️ `vacation` – A Trip or Journey

Each vacation represents a planned trip with its own packing list.

### Fields:
- `vacation_id`: UUID for the vacation (Primary Key).
- `vacation_name`: Name, e.g., "Summer Road Trip".
- `description`: Optional travel description.
- `start_date`: Date of departure.
- `user_id`: Foreign Key → `user.user_id`
- `creation_time`, `last_change`, `surrogate_key`: Metadata.

---

## 🗂️ `category` – Item Grouping

Categories help organize items logically.

### Fields:
- `category_id`: UUID for the category (Primary Key).
- `category_name`: Example: "Clothing", "Electronics".
- `user_id`: Foreign Key → `user.user_id`
- `creation_time`, `last_change`, `surrogate_key`: Metadata.

---

## 🎒 `item` – A Packable Object

The `item` table holds all packable objects, consumables, and containers.

### Fields:
- `item_id`: UUID (Primary Key).
- `item_name`: Descriptive name of the item.
- `picture`: Binary image of the item.
- `color`: Optional color label.
- `description`: Free-text notes.
- `weight`: e.g., 250g.
- `amount_unit`: e.g., "pcs", "liters".
- `consumeable`: Boolean; e.g., toothpaste = true.
- `tags`: Comma-separated keywords.
- `branding`: Brand name.
- `container`: Boolean; true if it can hold other items.
- `sort_no`: Suggested default sort order.
- `priority`: Importance (e.g., "ESSENTIAL").
- `price`: Value in currency.
- `active`: If false, item is hidden from selection.
- `category_id`: Foreign Key → `category.category_id`
- `user_id`: Foreign Key → `user.user_id`
- `creation_time`, `last_change`, `surrogate_key`: Metadata.

---

## 📋 `packlist` – Items Selected for a Vacation

This table links items to vacations with specific quantities and statuses.

### Fields:
- `packlist_id`: UUID (Primary Key).
- `vacation_id`: Foreign Key → `vacation.vacation_id`
- `item_id`: Foreign Key → `item.item_id`
- `amount`: How much to pack (can be decimal).
- `note`: Free-text instruction.
- `todo_note`: Task reminder (e.g., "Buy new one").
- `checked`: True if already packed.
- `extra_end_check`: Flag for final pre-departure check.
- `sort_no`: Custom ordering for the packing view.
- `creation_time`, `last_change`, `surrogate_key`: Metadata.

---

## 🧳 `nesting` – Items Inside Other Items

Describes recursive relationships where items are packed within containers.

### Fields:
- `nesting_id`: UUID (Primary Key).
- `container_item_id`: FK → `item.item_id` (must be a container).
- `content_item_id`: FK → `item.item_id` (the contained item).
- `amount`: Quantity of content inside the container.
- `creation_time`, `last_change`, `surrogate_key`: Metadata.

### Logic:
- Nesting is recursive but must not form cycles.
- Sum of nested quantities must not exceed the total from the `packlist`.

---

## 🔁 Design Principles

| Goal                            | Realized Through                             |
|--------------------------------|-----------------------------------------------|
| Multi-user support             | Foreign key `user_id` in all major tables     |
| Reusability                    | Central item catalog, linked via packlists    |
| Real-world modeling            | Nesting of items, priority, unit of measure   |
| Task awareness                 | To-do notes, packing status, end-check flags  |
| Maintainability                | UUIDs, timestamps, internal keys              |

---

## 📌 Summary of Table Relationships

- `user` ⬌ owns ⬌ `vacation`, `category`, `item`
- `vacation` ⬌ has many ⬌ `packlist` entries
- `item` ⬌ belongs to ⬌ `category`
- `item` ⬌ is reused via ⬌ `packlist`
- `nesting` ⬌ connects items into containers
