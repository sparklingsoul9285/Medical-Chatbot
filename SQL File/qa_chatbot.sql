-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 08, 2021 at 08:30 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `qa_chatbot`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminrecord`
--

CREATE TABLE IF NOT EXISTS `adminrecord` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `adminrecord`
--

INSERT INTO `adminrecord` (`aid`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `diseases_medicine`
--

CREATE TABLE IF NOT EXISTS `diseases_medicine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `symptons` text,
  `diseases` varchar(300) DEFAULT NULL,
  `medicine` text,
  `hospital_id` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=30 ;

--
-- Dumping data for table `diseases_medicine`
--

INSERT INTO `diseases_medicine` (`id`, `symptons`, `diseases`, `medicine`, `hospital_id`) VALUES
(1, 'Watery diarrhea.\nRice-water stools.\nFishy odor to stools.\nVomiting.\nRapid heart rate.\nLoss of skin elasticity. \nDry mucous membranes dry mouth.\nLow blood pressure.\nThirst.\nMuscle cramps (leg cramps, for example).\nRestlessness or irritability (especially in children).\nUnusual sleepiness or tiredness.\nRectal pain.\neye Pain.\nFever.\nSevere vomiting.\nDehydration.\nLow or no urine output.\nWeight loss.\nSeizures.\nShock.', 'Cholera', 'Antacids\r\nBismuth Subsalicylate\r\nHistamine H2 Receptor Antagonists\r\nHyoscyamine\r\nProton Pump Inhibitors\r\nSimethicone\r\nSodium Bicarbonate', '1,2,4,3,5'),
(2, 'Increased thirst.\r\nFrequent urination.\r\nExtreme hunger.\r\nUnexplained weight loss.\r\nFatigue.\r\nIrritability.\r\nBlurred vision.\r\nSlow-healing sores.\r\nFrequent infections, such as gums or skin infections and vaginal infections.', 'Diabetes', 'Anti-acne Cleansing (Topical)\r\nTopical Antibiotics (Clindamycin, Erythromycin)\r\nOral Antibiotics(Tetracyclines, Metronidazole)\r\nAzelaic Acid\r\nBenzoyl Peroxide\r\nIsotretinoin\r\nKeratolytics\r\nRetinoids (Topical)\r\n', '2,4,6,7'),
(3, 'poor appetite.\r\nheadaches.\r\ndiarrhea.\r\ngeneralized aches and pains.\r\nfever.\r\nlethargy.', 'Typhoid', 'Fluorouracil\r\nMasoprocol\r\n', '1,3,4'),
(4, 'Memory loss that disrupts daily life.\nChallenges in planning or solving problems.\nDifficulty completing familiar tasks.\nConfusion with time or place.\nTrouble understanding visual images and spatial relationships.\nNew problems with words in speaking or writing.\nMisplacing things and losing the ability to retrace steps.', 'Alzheimer''s disease', 'Antithrombotic Agents\r\nNitroglycerin\r\nAngiotensin Converting Enzyme (ACE) Inhibitors\r\nBeta-Adrenergic Blockers\r\nAngiotensin-Receptor Blockers\r\nThrombolytics', '1,5,7'),
(5, 'Shortness of breath.\r\nChest tightness or pain.\r\nTrouble sleeping caused by shortness of breath, coughing or wheezing.\r\nA whistling or wheezing sound when exhaling (wheezing is a common sign of asthma in children).', 'Asthama', 'Adrenocorticoids (Systemic)\r\n', '2,5,7'),
(6, 'itching, stinging, and burning between your toes or on soles of your feet.\r\nblisters on your feet that itch.\r\ncracking and peeling skin on your feet, most commonly between your toes and on your soles.\r\ndry skin on your soles or sides of your feet.\r\nraw skin on your feet.', 'Athlete''s foot', 'Dehydroepiandrosterone (DHEA)\r\n', '3,4,6'),
(8, 'A large brownish spot with darker speckles.\r\nA mole that changes in color, size or feel or that bleeds.\r\nA small lesion with an irregular border and portions that appear red, pink, white, blue or blue-black.\r\nA painful lesion that itches or burns.', 'Cancer Of The Skin', '	Benzodiazepines\r\n	Beta Adrenergic Blocking Agents\r\n	Carbamazepine\r\n	Disulfiram\r\n	Hydroxyzine\r\n	Lithium\r\n	Naltrexone\r\n	Thiamine\r\n	Phenobarbital\r\n', '5,7'),
(9, 'Severe headache.\r\nFatigue or confusion.\r\nVision problems.\r\nChest pain.\r\nDifficulty breathing.\r\nIrregular heartbeat.\r\nBlood in the urine.\r\nPounding in your chest, neck, or ears.', 'Hypertension', '	Adrenocorticoids (Nasal Inhalation, Oral Inhalation, Systemic)\r\n	Antihistamines\r\n	Antihistamines, Non-sedating\r\n	Antihistamines, Phenothiazine-Derivative\r\n	Azelastine\r\n	Cromolyn\r\n	Decongestants (Ophthalmic)\r\n	Ephedrine\r\n	Hydroxyzine\r\n', '1,7'),
(10, 'Difficulty falling asleep at night.\r\nWaking up during the night.\r\nWaking up too early.\r\nNot feeling well-rested after a night''s sleep.\r\nDaytime tiredness or sleepiness.\r\nIrritability, depression or anxiety.\r\nDifficulty paying attention, focusing on tasks or remembering.\r\nIncreased errors or accidents.', 'Insomnia', '	Dutasteride\r\n	Finasteride\r\n	Minoxidil\r\n', '1,5'),
(11, 'Feeling nauseated.\r\nVomiting.\r\nAbnormal or jerking eye movements (nystagmus)\r\nHeadache.\r\nSweating.\r\nRinging in the ears or hearing loss.', 'Vertigo', '	Carbonic Anhydrase Inhibitors\r\n', '3,7'),
(12, 'Red, swollen tonsils.\r\nWhite or yellow coating or patches on the tonsils.\r\nSore throat.\r\nDifficult or painful swallowing.\r\nFever.\r\nEnlarged, tender glands (lymph nodes) in the neck.\r\nA scratchy, muffled or throaty voice.\r\nBad breath.', 'Tonsillitis', '	Cholinesterase Inhibitors\r\n	Memantine\r\n', '3,5,7'),
(13, 'Pinkness or redness.\r\nSkin that feels warm or hot to the touch.\r\nPain, tenderness and itching.\r\nSwelling.\r\nSmall fluid-filled blisters, which may break.\r\nHeadache, fever, nausea and fatigue if the sunburn is severe', 'Sunburn', '	Chloroquine\r\n	Iodoquinol\r\n	Metronidazole\r\n', '2,4,6,7'),
(14, 'Delusions.\r\nHallucinations.\r\nDisorganized speech (e.g., frequent derailment or incoherence)\r\nGrossly disorganized or catatonic behavior.\r\nA set of three negative symptoms (a “flattening” of one''s emotions, alogia, avolition)', 'Schizophrenia', '	Bromocriptine\r\n	Progestins\r\n', '1,3,4,6'),
(15, 'Itching\r\nRash\r\nSores\r\nThick crusts', 'Scabies', ' Lateral Sclerosis (ALS)	Riluzole\r\n', '2,4,5'),
(16, 'pain or tenderness in the bones of the arms, legs, pelvis, or spine.\r\nstunted growth and short stature.\r\nbone fractures.\r\nmuscle cramps.\r\nteeth deformities, such as: delayed tooth formation. holes in the enamel. ...\r\nskeletal deformities, including: an oddly shaped skull. bowlegs, or legs that bow', 'Rickets', '	Adrenocorticoids (Systemic)\r\n	Androgens\r\n	Cyclosporine\r\n	Folic Acid\r\n	Iron Supplements\r\n	Leucovorin\r\n	Vitamin B-12\r\n', '2,5,7,6'),
(17, 'Tremor. A tremor, or shaking, usually begins in a limb, often your hand or fingers. \r\nSlowed movement (bradykinesia)\r\nRigid muscles\r\nImpaired posture and balance\r\nLoss of automatic movements\r\nSpeech changes\r\nWriting changes', 'Parkinson''s disease', '	Antiplatelet Agents\r\n	Beta Adrenergic Blocking Agents\r\n	Calcium Channel Blockers\r\n	Ranolazine\r\n	Nitrates\r\n', '1,2,3,6'),
(18, 'Fear of being contaminated by germs or dirt or contaminating others.\r\nFear of losing control and harming yourself or others.\r\nExcessive focus on religious or moral ideas.\r\nFear of losing or not having things you might need.', 'Obsessive compulsive disorder', '	Calcium Carbonate\r\n	Calcium Gluconate\r\n	Potassium Chloride\r\n	Antidepressants, Tricyclic\r\n	Progestins\r\n	Fluoxetine\r\n', '2,3,4,7'),
(19, 'headaches.\r\neye pain.\r\nnausea.\r\nvomiting.\r\nblurry, or cloudy vision.\r\nsensitivity to light.\r\ndifficulty seeing into the distance.', 'Obsessive compulsive disorder', '	Antidepressants (Tricyclic, SSRIs, SNRIs)\r\n	Barbiturates\r\n	Benzodiazepines\r\n	Beta Adrenergic Blocking Agents\r\n	Buspirone\r\n	Ergotamine, Beladonna and Phenobarbital\r\n	Haloperidol\r\n	Hydroxyzine\r\n	Loxapine\r\n	Meprobamate\r\n	Phenothiazines\r\n	Thiothixene\r\n', '3.5,7'),
(20, 'Night Blindness', 'Night Blindness', '	Antihistamines\r\n	Dronabinol\r\n	Megestrol\r\n', '2,4,5,7');

-- --------------------------------------------------------

--
-- Table structure for table `hospital_details`
--

CREATE TABLE IF NOT EXISTS `hospital_details` (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `h_name` varchar(50) DEFAULT NULL,
  `h_lat` varchar(30) DEFAULT NULL,
  `h_long` varchar(30) DEFAULT NULL,
  `h_mobile` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`h_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `hospital_details`
--

INSERT INTO `hospital_details` (`h_id`, `h_name`, `h_lat`, `h_long`, `h_mobile`) VALUES
(1, 'A Malkapur Hospital', '20.885628', '76.202502 ', '8275329929'),
(2, 'B Buldhana Hospital ', '20.530618', '76.184574', '8087808760'),
(3, 'C Akola Hospital', '20.710601', '77.014366', '8087808760'),
(4, 'Shegaon Hospital', '20.790013', '76.688980', '8087808760'),
(5, 'Akurdi Hospital', '18.652739', '73.780257', '8087808760'),
(6, 'Shivaji Nagar Hospital', '18.529770', '73.845818', '8087808760'),
(7, 'Talegaon Hospital', '73.674728', '18.738045', '8087808760'),
(8, 'Lonavala Hospital', '18.755412', '73.409147', '8087808760');

-- --------------------------------------------------------

--
-- Table structure for table `qa_hospital`
--

CREATE TABLE IF NOT EXISTS `qa_hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `h_id` varchar(30) DEFAULT NULL,
  `que` text,
  `answer` text,
  `q_rating` int(10) NOT NULL DEFAULT '0',
  `lk_count` int(10) NOT NULL DEFAULT '0',
  `dlk_count` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `qa_hospital`
--

INSERT INTO `qa_hospital` (`id`, `h_id`, `que`, `answer`, `q_rating`, `lk_count`, `dlk_count`) VALUES
(1, '1', 'which services are available', 'Infectious Disease Treatment\r\nSpecialty Diagnostics in Tuberculosis \r\nX Ray\r\nLaboratory\r\nAmbulance Services\r\nOPD', 0, 3, 0),
(2, '1', 'About Hospital', 'Veryyyyy nice hospital. This hospital is for infectious diseases only like hiv flu cat or dog bites. Medicines n most treatments r totally free', 0, 0, 0),
(3, '3', 'why best this hospital', 'Neat an clean hospital \r\nNice treatment\r\nGood for middle class family', 0, 0, 0),
(4, '4', 'why we refer your Hospital', 'This is one of the finest hospital for treatment of infectious diseases in Pune. Many people don''t know this hospital but the treatment here is much better and they are specialised in this.', 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE IF NOT EXISTS `user_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dob` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `pwd` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`id`, `fname`, `lname`, `mobile`, `email`, `dob`, `gender`, `pwd`) VALUES
(1, 'Ritesh', 'Surange', '8275329929', 'ritesh@gmail.com', '2017-10-30', 'Male', '123456'),
(2, 'Rahul', 'Shelke', '8900890099', 'rtss@gmail.com', '1993-02-11', 'Male', '123456');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
