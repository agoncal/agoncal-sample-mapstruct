# Samples - MapStruct - relationflat

Maps relations in domain to a flat dto.

There are 3 domain objects with relations :

```Organisation --> Address --> Country```

This maps the 3 objects to a flat DTO `OrganisationWithAddressDTO`

Problem : when mapping back the DTO to the 3 domain objects, even if all the address and country attributes are null, MapStruct will instanciate `Address` and `Country` and create the relationship with `Organisation`. I'm looking for a way to MapStruct not to instanciate these objects and set the relationships to null. 

# Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

<div class="footer">
    <span class="footerTitle"><span class="uc">a</span>ntonio <span class="uc">g</span>oncalves</span>
</div>