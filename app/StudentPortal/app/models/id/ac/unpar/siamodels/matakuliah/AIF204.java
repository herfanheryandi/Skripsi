package models.id.ac.unpar.siamodels.matakuliah;

import models.id.ac.unpar.siamodels.Mahasiswa;
import models.id.ac.unpar.siamodels.MataKuliah;
import models.id.ac.unpar.siamodels.matakuliah.interfaces.HasPrasyarat;

import java.util.List;

@MataKuliah(kode = "AIF204", nama = "Manajemen Informasi & Basis Data", sks = 4)
public class AIF204 implements HasPrasyarat {

	@Override
	public boolean checkPrasyarat(Mahasiswa mahasiswa, List<String> reasonsContainer) {
		boolean ok = true;
		int angkatan = mahasiswa.getTahunAngkatan();
		if (angkatan >= 2012 && angkatan <= 2014) {
			if (!mahasiswa.hasTempuhKuliah("AIF203")) {
				reasonsContainer.add("Angkatan " + angkatan + " tetapi tidak memenuhi prasyarat tempuh AIF103");			
				ok = false;
			}
		}
		return ok;
	}

}
