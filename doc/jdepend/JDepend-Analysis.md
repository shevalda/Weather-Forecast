# JDepend Analysis

This is a brief explaination about JDepend from [JDepend documentation](http://www.clarkware.com/software/JDepend.html)

**Number of Classes and Interfaces**

The number of concrete and abstract classes (and interfaces) in the package is an indicator of the extensibility of the package.

- **CC** - Concrete Class Count

- **AC** - Abstract Class (and Interface) Count

- **Ca** - Afferent Couplings (Ca)

The number of other packages that depend upon classes within the package is an indicator of the package's responsibility.

- **Ce** - Efferent Couplings (Ce)

The number of other packages that the classes in the package depend upon is an indicator of the package's independence.

- **A** - Abstractness (0-1)

The ratio of the number of abstract classes (and interfaces) in the analyzed package to the total number of classes in the analyzed package.

The range for this metric is 0 to 1, with A=0 indicating a completely concrete package and A=1 indicating a completely abstract package.

- **I** - Instability (0-1)

The ratio of efferent coupling (Ce) to total coupling (Ce + Ca) such that I = Ce / (Ce + Ca). This metric is an indicator of the package's resilience to change.

The range for this metric is 0 to 1, with I=0 indicating a completely stable package and I=1 indicating a completely instable package.

- **D** - Distance from the Main Sequence (0-1)

The perpendicular distance of a package from the idealized line A + I = 1. This metric is an indicator of the package's balance between abstractness and stability.

A package squarely on the main sequence is optimally balanced with respect to its abstractness and stability. Ideal packages are either completely abstract and stable (x=0, y=1) or completely concrete and instable (x=1, y=0).

The range for this metric is 0 to 1, with D=0 indicating a package that is coincident with the main sequence and D=1 indicating a package that is as far from the main sequence as possible.

- **Cyclic** - If the package contains a dependency cycle

#### com.aeolus.app

![]()

#### com.aeolus.app.holder

![]()

#### com.aeolus.utils

![]()

#### com.aeolus.view

![]()

#### com.aeolus.view.current

![]()

#### com.aeolus.view.future

![]()