package ru.inventarit;

import ru.inventarit.model.HasId;

public interface HasIdAndEmail extends HasId {
    String getEmail();
}
